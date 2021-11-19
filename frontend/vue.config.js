module.exports = {
    devServer: {
        port: 8081,
    },
    configureWebpack: {
        devServer: {
            watchOptions: {
            poll: true
            }
        }
    }
}
