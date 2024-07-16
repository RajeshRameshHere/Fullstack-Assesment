import './App.css';
import Navbar from './Layout/Navbar';
import "../node_modules/bootstrap/dist/css/bootstrap-grid.min.css"
import Home from './Pages/Home';
import { Route, BrowserRouter as Router,Routers,Routes } from 'react-router-dom';
import AddEmployee from './Employees/AddEmployee';
import AddVendors from './Vendors/AddVendors';
import ShowEmployee from './Employees/ShowEmployee';
import ShowVendors from './Vendors/ShowVendors'
import Inbox from './Email/Inbox';



function App() {
  return (
    <div className="App">
     
     <Router>
     <Navbar/>

     <Routes>
      <Route exact path="/" element={<Home/>}/>
      <Route exact path="/addemployee" element={<AddEmployee/>}/>
      <Route exact path="/addvendor" element={<AddVendors/>}/>
      <Route exact path="/showemployee" element={<ShowEmployee/>}/>
      <Route exact path="/showvendor" element={<ShowVendors/>}/>
      <Route exact path="/inbox" element={<Inbox/>}/>

     </Routes>
     </Router>
    </div>
  );
}

export default App;
