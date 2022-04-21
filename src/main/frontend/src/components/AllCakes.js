import { useState, useEffect } from 'react';

import CakeList from './CakeList';

const AllCakes = () => {
  const [cakes, setCakes] = useState([]);

  useEffect(() => {
    async function fetchCakes() {
      let response = await fetch('/cakes');
      response = await response.json();
      setCakes(response);
    }

    fetchCakes();
  }, []);

  return <CakeList cakes={cakes} />
}

export default AllCakes;
