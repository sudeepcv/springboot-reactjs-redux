import React from 'react';
import { Dashboard } from './component/Dashboard'
import { Header } from './component/layout/Header'

import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css';

function App() {
    return (
        <div className="App">        
            <Header />
            <Dashboard />            
        </div>
    );
}

export default App;
