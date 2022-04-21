import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import "./App.css";

import Header from "./components/Header";
import MainContent from "./components/MainContent";
import AllCakes from "./components/AllCakes";
import CakeForm from "./components/CakeForm";

function App() {
  return (
    <BrowserRouter>
      <Header />
      <MainContent>
        <Routes>
          <Route path="/" element={<AllCakes />} />
          <Route path="/addcake" element={<CakeForm />} />
        </Routes>
      </MainContent>
    </BrowserRouter>
  );
}

export default App;
