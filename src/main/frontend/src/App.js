import { useState, useEffect } from "react";

import Cake from "./Cake";

function App() {
  const [cakes, setCakes] = useState([]);

  useEffect(() => {
    async function fetchCakes() {
      let response = await fetch("/cakes");
      response = await response.json();
      setCakes(response);
    }

    fetchCakes();
  }, []);

  const cakesJsx = cakes.map((cake) => {
    return (
      <Cake
        title={cake.title}
        description={cake.description}
        image={cake.image}
      />
    );
  });

  return <div>{cakesJsx}</div>;
}

export default App;
