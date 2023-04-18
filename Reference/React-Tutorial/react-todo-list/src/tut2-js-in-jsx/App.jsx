/** 
Curly braces lets you to escape back into JavaScript
*/
import React from 'react';
import './style.css';

const user = {
  name: 'Hedy Lamarr',
  imageUrl: 'https://i.imgur.com/yXOvdOSs.jpg',
  imageSize: 90,
};

export default function App(){
  return(
    <div className="frame">
      <h1>{user.name}</h1>
      <img
        src={user.imageUrl}
        alt={'Photo of '+user.name}
        style={{
            width: user.imageSize,
            height: user.imageSize
          }}
      />
    </div>
  );
}