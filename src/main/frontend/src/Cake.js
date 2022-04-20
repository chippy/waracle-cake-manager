const Cake = (props) => {
  return (
    <div>
      <h1>{props.title}</h1>
      <p>{props.description}</p>
      <img src={props.image} />
    </div>
  );
};

export default Cake;