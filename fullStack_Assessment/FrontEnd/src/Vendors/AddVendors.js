import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './AddVenders.css'

export default function AddEmployee() {
    let navigate = useNavigate();
    const [vendors, setVendors] = useState({
        name: "",
        email: "",
        designation: "",
        ctc: ""
    });

    const { name, email, upi } = vendors;

    const onInputChange = (e) => {
        setVendors({ ...vendors, [e.target.name]: e.target.value });
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.post("http://localhost:8080/api/vendors/save", vendors);
            navigate('/'); // Redirect to the home page or another page after successful submission
        } catch (error) {
            console.error('Error saving employee:', error);
            alert('Failed to save employee. Please try again.');
        }
    };

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2>Register Vendors</h2>
                    <form onSubmit={onSubmit}>
                        <div className="mb-3">
                            <label htmlFor='Name' className='form-label'>Name</label>
                            <input
                                type="text"
                                className="form-control"
                                placeholder="Enter name"
                                name="name"
                                value={name}
                                onChange={onInputChange}
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor='Email' className='form-label'>Email</label>
                            <input
                                type="email"
                                className="form-control"
                                placeholder="Enter email"
                                name="email"
                                value={email}
                                onChange={onInputChange}
                            />
                        </div>
                       
                        <div className="mb-3">
                            <label htmlFor='UPI' className='form-label'>UPI</label>
                            <input
                                type="text"
                                className="form-control"
                                placeholder="Enter upi"
                                name="upi"
                                value={upi}
                                onChange={onInputChange}
                            />
                        </div>
                        <button type="submit" className="btn btn-outline-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    );
}
