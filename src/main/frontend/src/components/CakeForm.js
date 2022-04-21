import { useState } from "react";

const CakeForm = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [image, setImage] = useState('');

  const updateTitle = (event) => {
    setTitle(event.target.value);
  }

  const updateDescription = (event) => {
    setDescription(event.target.value);
  }

  const updateImage = (event) => {
    setImage(event.target.value);
  }

  return (
    <div class="ui centered fluid card">
      <div class="header">
        <h1>Add a Cake</h1>
      </div>
      <div class="content">
        <form class="ui form">
          <div class="field">
            <label>Title</label>
            <input type="text" name="title" value={title} onChange={updateTitle}/>
          </div>
          <div class="field">
            <label>Description</label>
            <input type="text" name="description" value={description} onChange={updateDescription} />
          </div>
          <div class="field">
            <label>Image</label>
            <input type="text" name="image" value={image} onChange={updateImage} />
          </div>
          <button type="submit" class="ui button blue">Add Cake</button>
        </form>
      </div>
    </div>
  )
};

export default CakeForm;