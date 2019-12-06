import React from 'react';
import  Dashboard  from './component/Dashboard'
import { Header } from './component/layout/Header'
import { BrowserRouter as Router, Route } from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css';
import {Provider} from 'react-redux'
import AddProject from './component/project/AddProject';
import store from './store'
import UpdateProject from './component/project/UpdateProject';

function App() {
    return (
        <Provider store={store}>       
        <Router> 
            <div className="App">
            <Header />
           
            <Route exact path="/" component={Dashboard}/>       
            <Route exact path="/dashboard" component={Dashboard} />
                 <Route exact path="/addProject" component={AddProject}/>
            <Route exact path="/updateProject/:id" component={UpdateProject}/>
        </div>
        </Router>
         </Provider>

    );
}

export default App;
