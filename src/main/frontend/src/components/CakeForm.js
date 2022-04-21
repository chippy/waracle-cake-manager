import { useState } from "react";

const CakeForm = (props) => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [image, setImage] = useState('');

  const [isTitleValid, setIsTitleValid] = useState(true);
  const [isDescriptionValid, setIsDescriptionValid] = useState(true);
  const [isImageValid, setIsImageValid] = useState(true);
  const [isFormComplete, setIsFormComplete] = useState(false);

  const updateTitle = (event) => {
    setTitle(event.target.value);
    validateForm();
  }

  const validateTitle = (event) => {
    setIsTitleValid(event.target.value.length > 0);
    validateForm();
  }

  const updateDescription = (event) => {
    setDescription(event.target.value);
    validateForm();
  }

  const validateDescription = (event) => {
    setIsDescriptionValid(event.target.value.length > 0);
    validateForm();
  }

  const updateImage = (event) => {
    setImage(event.target.value);
    validateForm();
  }

  const validateImage = (event) => {
    setIsImageValid(event.target.value.length > 0);
    validateForm();
  }

  const validateForm = () => {
    setIsFormComplete(title.length > 0 && description.length > 0 && image.length > 0);
  }

  const addCake = (event) => {
    event.preventDefault();
    props.onAddCake(title, description, image);
  }

  return (
    <div class="ui centered fluid card">  
      <div class="header">
        <h1>Add a Cake</h1>
      </div>
      <div class="content">
        <form class="ui form">
          <div class={`field ${isTitleValid ? '' : 'error'}`}>
            <label>Title</label>
            <input type="text" name="title" value={title} onChange={updateTitle} onBlur={validateTitle} />
          </div>
          <div class={`field ${isDescriptionValid ? '' : 'error'}`}>
            <label>Description</label>
            <input type="text" name="description" value={description} onChange={updateDescription} onBlur={validateDescription} />
          </div>
          <div class={`field ${isImageValid ? '' : 'error'}`}>
            <label>Image</label>
            <input type="text" name="image" value={image} onChange={updateImage} onBlur={validateImage}/>
          </div>
          <button type="submit" class="ui button blue" disabled={!isFormComplete} onClick={addCake}>Add Cake</button>
        </form>
      </div>
    </div>
  )
};

export default CakeForm;