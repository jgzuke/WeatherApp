#Design Decisions

###Json Parsing
I used [LoganSquare](https://github.com/bluelinelabs/LoganSquare) to parse the json response because it is incredibly fast and allows extra parameters to very easily be added to the model.

###Weather icons
I chose to use [WeatherIconView](https://github.com/pwittchen/WeatherIconView) for the icons, because it allowed icons to be easily replaced or added for new conditions compared to using images, and I didnt't like the default images from the openweather api.