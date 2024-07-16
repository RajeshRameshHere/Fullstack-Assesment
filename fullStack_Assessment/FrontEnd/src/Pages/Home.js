import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom'
import './Home.css'
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import 'bootstrap/dist/js/bootstrap.bundle.min.js'; // Import Bootstrap JavaScript


export default function Home() {
    return (
    <div>
        <h1>Welcome To CredMerg</h1>
    <Link className="btn- btn-outline-light" to="/showemployee">Show Employee</Link><br/>
    <Link className="btn- btn-outline-light" to="/showvendor">Show Vendor</Link><br/>
    <Link className="btn- btn-outline-light" to="/addemployee">Add Employee</Link><br/>
    <Link className="btn- btn-outline-light" to="/addvendor">Add Vendor</Link><br/>
    <Link className="btn- btn-outline-light" to="/inbox">Inbox</Link><br/>
    <Link className="btn- btn-outline-light" to="/">Home</Link><br/>



    </div>

    )
 
}
