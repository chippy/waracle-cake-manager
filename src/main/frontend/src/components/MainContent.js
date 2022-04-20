const MainContent = (props) => {
  return (
    <div className='ui main center aligned text container cake-list'>
      {props.children}
    </div>
  );
};

export default MainContent;
