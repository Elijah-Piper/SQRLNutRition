import React from 'react';
import '../App.css';
import UserService from '../Service/UserService.js';

function Admin()	{
	const headStyle ={
		display:"flex"
	}
	var name = localStorage.getItem("signedInUsername");
	name = name ? name : "logged out";
	return (
		<div>
			<header>
				<h1 classname="headStyle">
					You are {name} <br/>
					{name === "admin" ? "Congrats!" : "You are not admin lol"}
				</h1>
			</header>
		</div>
	);
}

export default Admin;
