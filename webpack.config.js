const webpack = require('webpack');

module.exports = {
    entry: './src/main/js/index.js',
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                use: ['babel-loader']
            },
            {
                test: /\.css$/,
                use: [
                    {loader: "style-loader"},
                    {loader: "css-loader"}
                ]
            }
        ]
    },
    resolve: {
        extensions: ['*', '.js', '.jsx', 'css'],
        modules: [
            'node_modules'
        ]
    },
    output: {
        path: __dirname,
        filename: './src/main/resources/static/bundle.js'
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin()
    ],
    devServer: {
        contentBase: './dist',
        hot: true
    }
};
