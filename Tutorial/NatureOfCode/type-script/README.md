TypeScript is a syntactic superset of JavaScript which adds static typing.

JavaScript is a loosely typed language. It can be difficult to understand what types of data
are being passed around in JavaScript.

Install TypeScript: Installs typescript globally
    sudo npm i -g typescript

Show TypeScript version:
    tsc --version

Show TypeScript config:
    npx tsc --init

Configure Default behavior:
    "include": ["src"],                    
    "compilerOptions": {
    "outDir": "./build"
    }

Primitives in JS and TS:

    boolean - true and false
    number - whole numbers and floating point values
    string - text values

Type Assignment:

    Explicit - write out the type.
        let firstName: string = "Dylan";

    Inplicit - TS will infer the type.
        let firstName = "Dylan";

Type: any
    Disables type checking. Good for small testing but never for production.

TypeScript Arrays:
    const names: string[] = [];
    names.push("Dylan");
