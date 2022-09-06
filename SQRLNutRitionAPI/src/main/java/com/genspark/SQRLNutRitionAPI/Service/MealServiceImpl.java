package com.genspark.SQRLNutRitionAPI.Service;

import com.genspark.SQRLNutRitionAPI.Dao.MealDao;
import com.genspark.SQRLNutRitionAPI.Entity.Meal;
import com.genspark.SQRLNutRitionAPI.Entity.Squirrel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealDao mealDao;

    @Override
    public Meal createMeal(Meal meal) {
        return this.mealDao.save(meal);
    }

    @Override
    public Meal updateMeal(Meal meal) {
        return this.mealDao.save(meal);
    }

    @Override
    public List<Meal> getMealsBySquirrel(Squirrel sqrl) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Query q = session.createQuery("from Meal where squirrel=:sqrl");
        q.setParameter("sqrl", sqrl);

        List<Meal> list = q.list();

        session.close();
        factory.close();

        return list;
    }

    @Override
    public Meal getMealById(int id) {
        Optional<Meal> m = this.mealDao.findById(id);
        Meal meal = null;
        if (m.isPresent()) {
            meal = m.get();
        } else {
            throw new RuntimeException("Meal not found for id :: " + id);
        }

        return meal;
    }

    @Override
    public String deleteMealsBySquirrel(Squirrel sqrl) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Query q = session.createQuery("delete Meal where squirrel:=sqrl");
        q.setParameter("sqrl", sqrl);
        int status = q.executeUpdate();

        t.commit();
        factory.close();
        session.close();

        return "" + status + " squirrel entries successfully deleted";
    }

    @Override
    public String deleteMealById(int id) {
        this.mealDao.deleteById(id);
        return "Meal successfully deleted";
    }
}
