import React from 'react';
import { Link } from 'react-router-dom';
import './NavBar.css'; // Import the CSS file
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import 'bootstrap/dist/js/bootstrap.bundle.min.js'; // Import Bootstrap JavaScript

export default function Navbar() {
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
        <div className="container-fluid">
          <a className="navbar-brand" href="#">
            Cred Merg
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item dropdown">
                <a
                  className="nav-link dropdown-toggle"
                  href="#"
                  id="navbarDropdownEmployees"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  Employees
                </a>
                <ul className="dropdown-menu" aria-labelledby="navbarDropdownEmployees">
                  <li><Link className="dropdown-item" to="/addemployee">Add Employee</Link></li>
                  <li><Link className="dropdown-item" to="/showemployee">Show Employees</Link></li>
                </ul>
              </li>
              <li className="nav-item dropdown">
                <a
                  className="nav-link dropdown-toggle"
                  href="#"
                  id="navbarDropdownVendors"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  Vendors
                </a>
                <ul className="dropdown-menu" aria-labelledby="navbarDropdownVendors">
                  <li><Link className="dropdown-item" to="/addvendor">Add Vendor</Link></li>
                  <li><Link className="dropdown-item" to="/showvendor">Show Vendors</Link></li>
                </ul>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/inbox">Inbox</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/">Home</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  );
}
