import { useState } from 'react';
import cake from '../images/portal-cake.jpg';

const Cake = (props) => {
  const replaceImage = (event) => {
    event.target.src = cake;
    event.target.alt = 'The cake is a lie.';
  };

  return (
    <div>
      <h1>{props.title}</h1>
      <p>{props.description}</p>
      <img
        src={props.image}
        alt={props.title}
        className='cake-image'
        onError={replaceImage}
      />
      <hr />
    </div>
  );
};

export default Cake;
