import { NavLink } from 'react-router-dom';

const Header = () => {
  return (
    <div className='ui fixed inverted orange top menu'>
      <div class='ui header item'>Waracle's Cakes</div>
      <NavLink to='/' className='item' activeClassName='item active'>
        List Cakes
      </NavLink>
      <NavLink
        to='/addcake'
        className='item center'
        activeClassName='item active'
      >
        Add a Cake
      </NavLink>
    </div>
  );
};

export default Header;
