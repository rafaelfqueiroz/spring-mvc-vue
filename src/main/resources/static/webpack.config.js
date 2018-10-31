const path = require('path');

module.exports = {
  entry: './js/app/products/index.js',
  output: {
    filename: 'main.js',
    path: path.resolve(__dirname, './js/dist')
  }
};