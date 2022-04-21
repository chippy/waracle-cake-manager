import { useState } from 'react';
import portalCake from '../images/portal-cake.jpg';

const Cake = (props) => {
  const [cakeImage, setCakeImage] = useState(props.image);

  const replaceImage = () => {
    setCakeImage(portalCake);
  };

  return (
    <div>
      <h1>{props.title}</h1>
      <p>{props.description}</p>
      <img
        src={cakeImage}
        alt={props.description}
        className='cake-image'
        onError={replaceImage}
      />
      <hr />
    </div>
  );
};

export default Cake;
