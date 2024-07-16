import React from 'react'
import  { useEffect, useState } from 'react';
import axios from 'axios';

export default function ShowEmployee() {

    const [vendors, setVendors] = useState([]);

    useEffect(() => {
      loadUsers();
      console.log("success");
    }, []);
  
    const loadUsers = async () => {
      try {
        const result = await axios.get("http://localhost:8080/api/vendors/showall");
        if (result.data.contents) {
          setVendors(result.data.contents); // Access the array inside the 'contents' property
        }
        console.log(result.data);
      } catch (error) {
        console.error('Error fetching employee data:', error);
      }
    };
  
    return (
      <div className='container'>
        <div className='py-4'>
          <h2>Vendor Table</h2>
          <table className='table border'>
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">UPI</th>
              </tr>
            </thead>
            <tbody>
              {vendors.length > 0 ? (
                vendors.map((employee, index) => (
                  <tr key={index}>
                    <th scope="row">{index + 1}</th>
                    <td>{employee.name}</td>
                    <td>{employee.email}</td>
                    <td>{employee.upi}</td>
                  </tr>
                ))
              ) : (
                <tr>
                  <td colSpan="5">No vendors found.</td>
                </tr>
              )}
            </tbody>
          </table>
        </div>
      </div>
    );
}
