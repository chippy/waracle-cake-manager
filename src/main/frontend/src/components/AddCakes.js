import { useState } from "react";

import CakeForm from './CakeForm';
import CakeList from "./CakeList";

const AddCakes = () => {
  const [addedCakes, setAddedCakes] = useState([]);

  const addCake = (title, description, image) => {
    let newCake = {
      title: title,
      description: description,
      image: image
    }

    fetch("cakes", {
      method: "POST",
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(newCake)
    })
    .then(response => response.json())
    .then(data => {
      console.log('Success: ', data);
      setAddedCakes([...addedCakes, data]);
    })
    .catch(error => console.log("Error: " + error));
  }

  const renderAddedCakes = () => {
    if (addedCakes.length ===0) return null;

    return (
      <>
        <div class="header">
          Added Cakes:
        </div>
        <CakeList cakes={addedCakes} />
      </>
    )
  }

  return (
    <>
      <CakeForm onAddCake={addCake}/>
      {renderAddedCakes()}
    </>
    );
}

export default AddCakes;