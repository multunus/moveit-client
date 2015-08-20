cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "file": "plugins/com.orcasinc.childbrowser/www/childbrowser.js",
        "id": "com.orcasinc.childbrowser.ChildBrowser",
        "clobbers": [
            "ChildBrowser"
        ]
    },
    {
        "file": "plugins/org.apache.cordova.inappbrowser/www/inappbrowser.js",
        "id": "org.apache.cordova.inappbrowser.inappbrowser",
        "clobbers": [
            "window.open"
        ]
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "com.orcasinc.childbrowser": "5.0.2",
    "org.apache.cordova.inappbrowser": "0.6.0"
}
// BOTTOM OF METADATA
});