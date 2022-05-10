import { useEffect, useState } from 'react';

const CakeForm = (props) => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [image, setImage] = useState('');

  const [isTitleValid, setIsTitleValid] = useState(true);
  const [isDescriptionValid, setIsDescriptionValid] = useState(true);
  const [isImageValid, setIsImageValid] = useState(true);
  const [isFormComplete, setIsFormComplete] = useState(false);

  useEffect(() => {
    setIsFormComplete(
      title.length > 0 && description.length > 0 && image.length > 0
    );
  }, [title, description, image]);

  const updateTitle = (event) => {
    setTitle(event.target.value);
  };

  const validateTitle = (event) => {
    setIsTitleValid(event.target.value.length > 0);
  };

  const updateDescription = (event) => {
    setDescription(event.target.value);
  };

  const validateDescription = (event) => {
    setIsDescriptionValid(event.target.value.length > 0);
  };

  const updateImage = (event) => {
    setImage(event.target.value);
  };

  const validateImage = (event) => {
    setIsImageValid(event.target.value.length > 0);
  };

  const resetForm = () => {
    setTitle('');
    setDescription('');
    setImage('');
    setIsTitleValid(true);
    setIsDescriptionValid(true);
    setIsImageValid(true);
    setIsFormComplete(false);
  };

  const addCake = (event) => {
    event.preventDefault();
    props.onAddCake(title, description, image);
    resetForm();
  };

  return (
    <div className='ui centered fluid card'>
      <div className='header'>
        <h1>Add a Cake</h1>
      </div>
      <div className='content'>
        <form className='ui form'>
          <div className={`field ${isTitleValid ? '' : 'error'}`}>
            <label>Title</label>
            <input
              type='text'
              name='title'
              value={title}
              onChange={updateTitle}
              onBlur={validateTitle}
            />
          </div>
          <div className={`field ${isDescriptionValid ? '' : 'error'}`}>
            <label>Description</label>
            <input
              type='text'
              name='description'
              value={description}
              onChange={updateDescription}
              onBlur={validateDescription}
            />
          </div>
          <div className={`field ${isImageValid ? '' : 'error'}`}>
            <label>Image</label>
            <input
              type='text'
              name='image'
              value={image}
              onChange={updateImage}
              onBlur={validateImage}
            />
          </div>
          <button
            type='submit'
            className='ui button blue'
            disabled={!isFormComplete}
            onClick={addCake}
          >
            Add Cake
          </button>
        </form>
      </div>
    </div>
  );
};

export default CakeForm;
