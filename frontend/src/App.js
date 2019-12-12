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
import ProjectBoard from './component/ProjectBoard/ProjectBoard';
import AddProjectTask from './component/ProjectBoard/ProjectTasks/AddProjectTask';
import UpdateProjectTask from './component/ProjectBoard/ProjectTasks/UpdateProjectTask.js';

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
            <Route exact path="/projectBoard/:id" component={ProjectBoard}/>
                <Route
              exact
              path="/addProjectTask/:id"
              component={AddProjectTask}
            />
               <Route
              exact
              path="/updateProjectTask/:backlog_id/:pt_id"
              component={UpdateProjectTask}
            />

            
        </div>
        </Router>
         </Provider>

    );
}

export default App;
