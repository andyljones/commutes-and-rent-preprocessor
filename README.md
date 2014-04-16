This is the preprocessor for an [exploration of commutes & rent in London](andyljones.github.io/pages/commutes-and-rent). 

<p align="center">
<img src="http://i.minus.com/iEpN95jpWRIBq.png">
</p>

It has three purposes: 

 - It sucks up [Transport For London timetable data](http://www.tfl.gov.uk/info-for/open-data-users/) and uses it to generate a large number of JSON files which encode what time you'd have to leave each station in the Underground network in order to arrive at each other station by a specified time.
 
  This is done by processing the timetable data into a transit graph, then carrying out a dynamic programming algorithm strongly reminiscent of [Dijkstra's](http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm) (supplemented with a few culling heuristics) for each destination station.

 - It uses the station location information from TFL along with postcode and rent information from the [Office of National Statistics](http://www.statistics.gov.uk/hub/index.html) to produce a JSON file that maps stations to the rent statistics of the Local Authority District they lie in.

 - It uses the station location information (along with a hand-crafted file of corrections) to produce a JSON file that maps station names from the TfL data to coordinates.

Using these three sets of files, the [frontend](https://github.com/andyljones/commutes-and-rent-frontend) can generate a map of the stations and a chart of travel times between each and the rents in the areas around them.
