import { NavLink } from 'react-router-dom';

const Header = () => {
  return (
    <div className='ui fixed inverted orange top menu'>
      <div className='ui header item'>Waracle's Cakes</div>
      <NavLink to='/' className='item' activeclassname='item active'>
        List Cakes
      </NavLink>
      <NavLink
        to='/addcake'
        className='item center'
        activeclassname='item active'
      >
        Add a Cake
      </NavLink>
    </div>
  );
};

export default Header;
