# MoveIt Client  [![Circle CI](https://circleci.com/gh/multunus/moveit-client/tree/master.svg?style=svg)](https://circleci.com/gh/multunus/moveit-client/tree/master)

Cordova wrapper around web bundle to convert it to a mobile app.

For more details of our MoveIt app, [head here](https://github.com/multunus/moveit-rails).

## Usage

- Install Cordova
```
npm install -g cordova
```
- Install npm dependencies
```
npm install
```
- Add Remote for Shared Client
```
git remote add -f moveit-shared-client https://github.com/multunus/moveit-shared-client.git
```
- Pull changes to Client
```
git subtree pull --prefix www moveit-shared-client master --squash
```
- Build and run app in your device
```
cordova run android
```

### Updating version
Update version number in `config.xml`

## Contributing

See the [CONTRIBUTING] document.
Thank you, [contributors]!

  [CONTRIBUTING]: CONTRIBUTING.md
  [contributors]: https://github.com/multunus/moveit-client/graphs/contributors

## License

MoveIt and MoveIt Client are Copyright (c) 2016 Multunus Software Pvt. Ltd.
It is free software, and may be redistributed
under the terms specified in the [LICENSE] file.

  [LICENSE]: /LICENSE

## About

![multunus](https://s3.amazonaws.com/multunus-images/Multunus_Logo_Vector_resized.png)

MoveIt and MoveIt Client is maintained and funded by Multunus Software Pvt. Ltd.
The names and logos for Multunus are trademarks of Multunus Software Pvt. Ltd.

We love open source software!
See [our other projects][community]
or [hire us][hire] to help build your product.

  [community]: http://www.multunus.com/community?utm_source=github
  [hire]: http://www.multunus.com/contact?utm_source=github
