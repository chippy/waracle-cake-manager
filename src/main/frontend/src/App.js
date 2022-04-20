import React from 'react';

import './App.css';

import Header from './components/Header';
import MainContent from './components/MainContent';
import CakeList from './components/CakeList';

function App() {
  return (
    <>
      <Header />
      <MainContent>
        <CakeList />
      </MainContent>
    </>
  );
}

export default App;
