/** 
React components are JavaScript components that return markup.

JSX is stricter than HTML. Tou have to close tags and you can't return multiple JSX tags. You have
to wrap them in a <div></div> or empty wrapper <></>
*/

function MyButton(){
  return(
    <button>
      OK
    </button>
  );
}

export default function App(){
  return(
    <div>
      <h1>Welcome to my app</h1>
      <MyButton/>
    </div>
  );
}