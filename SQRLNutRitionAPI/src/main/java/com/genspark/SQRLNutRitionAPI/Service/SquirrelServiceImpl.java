package com.genspark.SQRLNutRitionAPI.Service;

import com.genspark.SQRLNutRitionAPI.Dao.SquirrelDao;
import com.genspark.SQRLNutRitionAPI.Entity.Squirrel;
import com.genspark.SQRLNutRitionAPI.Entity.User;
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
public class SquirrelServiceImpl implements SquirrelService {

    @Autowired
    private SquirrelDao squirrelDao;

    @Override
    public Squirrel createSquirrel(Squirrel sqrl) {
        return this.squirrelDao.save(sqrl);
    }

    @Override
    public Squirrel updateSquirrel(Squirrel sqrl) {
        return this.squirrelDao.save(sqrl);
    }

    @Override
    public List<Squirrel> getSquirrelsByUser(User user) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Query q = session.createQuery("from Squirrel where user=:u");
        q.setParameter("u", user);

        List<Squirrel> list = q.list();

        session.close();
        factory.close();

        return list;
    }

    @Override
    public Squirrel getSquirrelById(int id) {
        Optional<Squirrel> s = this.squirrelDao.findById(id);
        Squirrel sqrl = null;
        if (s.isPresent()) {
            sqrl = s.get();
        } else {
            throw new RuntimeException("Squirrel not found for id :: " + id);
        }

        return sqrl;
    }

    @Override
    public String deleteSquirrelsByUser(User user) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Query q = session.createQuery("delete Squirrel where user:=u");
        q.setParameter("u", user);
        int status = q.executeUpdate();

        t.commit();
        factory.close();
        session.close();

        return "" + status + " squirrel entries successfully deleted";
    }

    @Override
    public String deleteSquirrelById(int id) {
        this.squirrelDao.deleteById(id);
        return "Squirrel successfully deleted";
    }
}
