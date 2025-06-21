import {Route ,Routes} from "react-router-dom";
import './App.css';
import Header from './Pages/header/Header';
import Dashboard from "./Pages/Dashboard/Dashboard";
import No_Match from "./Pages/No_Match/No_Match";
import PostUser from "./Pages/Employee/PostUser";
import UpdateUser from "./Pages/Employee/UpdateUser";

function App() {
  return (
    <>
      <Header />
      <Routes>
        <Route path="/" element={<Dashboard/>} />
        <Route path="/employee" element={<PostUser />}/>
        <Route path="/employee/:id" element={<UpdateUser />}/>
        <Route path="*" element={<No_Match />} /> 
        {/* path="*" acts as a wildcard route.It matches any URL that doesn’t match any of the other defined routes.*/}
      </Routes>
    </>
  );
}

export default App;
