import React from 'react';
import { Dashboard } from './component/Dashboard'
import { Header } from './component/layout/Header'
import { BrowserRouter as Router, Route } from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css';
import AddProject from './component/project/AddProject';

function App() {
    return (
        <Router> 
            <div className="App">
            <Header />
           
            <Route exact path="/" component={Dashboard}/>
            <Route exact path="/addProject" component={AddProject}/>
        </div>
        </Router>

    );
}

export default App;
