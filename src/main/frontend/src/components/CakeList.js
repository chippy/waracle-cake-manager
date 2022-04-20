import { useState, useEffect } from 'react';

import Cake from './Cake';

function CakeList() {
  const [cakes, setCakes] = useState([]);

  useEffect(() => {
    async function fetchCakes() {
      let response = await fetch('/cakes');
      response = await response.json();
      setCakes(response);
    }

    fetchCakes();
  }, []);

  const cakesJsx = cakes.map((cake) => {
    return (
      <Cake
        key={cake.id}
        title={cake.title}
        description={cake.description}
        image={cake.image}
      />
    );
  });

  return <div>{cakesJsx}</div>;
}

export default CakeList;
