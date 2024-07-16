import React ,  { useEffect, useState } from 'react';
import axios from 'axios';
import "./ShowEmployee.css"

export default function ShowEmployee() {

    const [employees, setEmployees] = useState([]);

    useEffect(() => {
      loadUsers();
      console.log("success");
    }, []);
  
    const loadUsers = async () => {
      try {
        const result = await axios.get("http://localhost:8080/api/employee/showall");
        if (result.data.contents) {
          setEmployees(result.data.contents); // Access the array inside the 'contents' property
        }
        console.log(result.data);
      } catch (error) {
        console.error('Error fetching employee data:', error);
      }
    };
  
    return (
      <div className='container'>
        <div className='py-4'>
          <h2>Employee Table</h2>
          <table className='table border'>
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Designation</th>
                <th scope="col">CTC</th>
              </tr>
            </thead>
            <tbody>
              {employees.length > 0 ? (
                employees.map((employee, index) => (
                  <tr key={index}>
                    <th scope="row">{index + 1}</th>
                    <td>{employee.name}</td>
                    <td>{employee.email}</td>
                    <td>{employee.designation}</td>
                    <td>{employee.ctc}</td>
                  </tr>
                ))
              ) : (
                <tr>
                  <td colSpan="5">No employees found.</td>
                </tr>
              )}
            </tbody>
          </table>
        </div>
      </div>
    );
}
