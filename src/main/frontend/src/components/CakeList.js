import Cake from './Cake';

const CakeList = (props) => {
  const cakesJsx = props.cakes.map((cake) => {
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
