import React ,  { useEffect, useState } from 'react';
import axios from 'axios';
import './inbox.css'
export default function Inbox() { 
    
    const [emails, setEmails] = useState([]);

    useEffect(() => {
      loadUsers();
      console.log("success");
    }, []);
  
    const loadUsers = async () => {
      try {
        const result = await axios.get("http://localhost:8080/api/email/inbox");
        if (result.data.contents) {
          setEmails(result.data.contents); // Access the array inside the 'contents' property
        }
        console.log("raju")
        console.log(result.data);
      } catch (error) {
        console.error('Error fetching email data:', error);
      }
    };
  
    return (
      <div className='container'>
        <div className='py-4'>
          <h2>Inbox</h2>
          <table className='table border'>
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Body</th>
                <th scope="col">Sub</th>
                <th scope="col">To</th>
              </tr>
            </thead>
            <tbody>
              {emails.length > 0 ? (
                emails.map((email, index) => (
                  <tr key={index}>
                    <th scope="row">{index + 1}</th>
                    <td>{email.body}</td>
                    <td>{email.sub}</td>
                    <td>{email.to}</td>
                  </tr>
                ))
              ) : (
                <tr>
                  <td colSpan="5">No emails found.</td>
                </tr>
              )}
            </tbody>
          </table>
        </div>
      </div>
    );
}
