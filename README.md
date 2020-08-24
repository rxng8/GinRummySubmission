# gin-rummy-eaai
Gin Rummy software for the Gin Rummy EAAI Undergraduate Research Challenge

<!-- # About the project -->

<!-- Attached is the JAR package (one folder containing a single file with every dependencies packaged and one folder containing separated dependencies jar files)
Here is the AlexTomBot.jar file structure (You can run `jar tf AlexTomBot.jar` to view the file structure):

```
META-INF/MANIFEST.MF
ginrummy/
ginrummy/Card.class
ginrummy/ExternalGinRummyGame.class
ginrummy/GinRummyGame.class
ginrummy/GinRummyPlayer.class
ginrummy/GinRummyUtil$FileResource.class
ginrummy/GinRummyUtil.class
ginrummy/SimpleFileGinRummyPlayer.class
ginrummy/SimpleGinRummyPlayer.class
META-INF/
model/model/dense.h5
model/dense_config.json
model/dense_weights.h5
model/drawing.h5
model/drawing_config.json
model/drawing_weights.h5
model/handEst1-10000.dat
model/hit_100_v1.h5
model/hit_100_v1_config.json
model/hit_100_v1_weights.h5
model/hit_100_v2.h5
model/hit_100_v2_config.json
model/hit_100_v2_weights.h5
model/hit_100_v3.h5
model/hit_100_v3_config.json
model/hit_100_v3_weights.h5
model/hit_100_v4.h5
model/hit_100_v4_config.json
model/hit_100_v4_weights.h5
model/hit_100_v5.h5
model/hit_100_v5_config.json
model/hit_100_v5_weights.h5
model/hit_100_v6.h5
model/hit_100_v6_config.json
model/hit_100_v6_weights.h5
model/knocking_100.h5
model/knocking_100_config.json
model/knocking_100_v2.h5
model/knocking_100_v2_config.json
model/knocking_100_v2_weights.h5
model/knocking_100_weights.h5
model/knocking_30.h5
model/knocking_30_config.json
model/knocking_30_weights.h5
model/lstm_100_100epoch.h5
model/lstm_100_100epoch_config.json
model/lstm_100_100epoch_weights.h5
model/lstm_100_200epoch.h5
model/lstm_100_200epoch_config.json
model/lstm_100_200epoch_weights.h5
model/lstm_100_500epoch.h5
model/lstm_100_500epoch_config.json
model/lstm_100_500epoch_weights.h5
model/lstm_200_150epoch.h5
model/lstm_200_150epoch_config.json
model/lstm_200_150epoch_weights.h5
model/lstm_200_200epoch.h5
model/lstm_200_200epoch_config.json
model/lstm_200_200epoch_weights.h5
model/test.h5
model/test_config.json
model/test_weights.h5
module/
module/HandEstimator.class
module/HandEstimator2.class
module/HandEstimator3.class
module/HittingModule.class
module/KnockingModule.class
module/Module.class
module/PlayerGameState.class
player/                                                                                                                player/AdvancedPlayer.class
player/EstimatingPlayer.class
player/HittingPlayer.class
player/KnockingPlayer.class
player/MediumPlayerEK.class
player/MediumPlayerHE.class
player/MediumPlayerKH.class
util/util/Maths.class
util/Util.class
util/WilsonInterval.class
``` -->

# About the players

**Hitting Player** is constructed from Simple Player plus the hitting module in the associated class, so this player can draw and collect hitting cards and also discard appropriate cards from hand based on the individual card value predicted by pretrained model in the hitting module.

**Estimating Player** is constructed from Simple Player plus the estimating module module in the associated class, so this player can discard safely based on opponent's hand estimation predicted by the pretrained model in the estimating module.

**Knocking Player** is constructed from Simple Player plus the knocking module in the associated class, so this player know when the right time to knock in the current is.

**Medium Player HE** is constructed from Hitting Player and Estimating Player with their functionalities and modules. This player will draw and discard based on estimated card value and also play safe discard strategy.

**Medium Player KH** is constructed from Hitting Player and Knocking Player with their functionalities and modules. This player will draw and discard based on estimated card value and also knock at the right time.

**Medium Player EK** is constructed from Estimating Player and Knocking Player with their functionalities and modules. This player will play safe discard strategy and also knock at the right time.

**Advanced Player** is constructed from Hitting Player, Estimating Player, and Knocking Player with their functionalities and modules. This player will draw and discard based on estimated card value, play safe discard strategy, and also knock at the right time.


# Build from source:
1. Clean, Install, Compile, and Package my Maven project

```
mvn clean install compile package
```
- Clean will remove the target folder
- Install will install dependencies locally
- compile will compile the source code in source/main/java.
- package will package the project into jar, this jar contains dependencies and also my code. I will compile the vermouth code with this project's classes from source.

2. Since the project was only compatible for JRE 1.8, other version may not work. To compile the vermouth code, first test if the dependencies are good:

```
# Navigate to root containing packages
# On linux terminal

# Test if the dependencies can initialize
java -jar "./target/botpackage-0.1.0.jar"
or
java -jar "./target/botpackage-0.1.0.jar" HelloWorld
or
java -cp ./target/botpackage-0.1.0.jar HelloWorld

```

3. Compile the project code with vermounth.jar and the botpackage.jar with slf4j external library.

```
# Make sure each of the java file contains has an associated .class file besides.

javac -cp "./src/main/java:./vermouth.jar:./target/botpackage-0.1.0.jar:./assets/slf4j-simple-2.0.0-alpha1.jar" ./src/main/java/*.java
```
Or you can use the compiled code by maven in the path `./target/classes` that was compiled before by the command `mvn compile`.


4. Run the vermouth code
- with player in the jar file
```
java -cp ./target/botpackage-0.1.0.jar:./assets/slf4j-simple-2.0.0-alpha1.jar:./vermouth/vermouth.jar eaai.ginrummy.Main --oneall --games 100 --agents 'jar:file:./target/botpackage-0.1.0.jar!/AdvancedPlayer' 'jar:file:./target/botpackage-0.1.0.jar!/AdvancedPlayer'
```
- With the source file in the directory.
```
java -jar ./vermouth/vermouth.jar --oneall --games 100 --agents 'file:./target/classes/AdvancedPlayer' 'file:./target/classes/AdvancedPlayer' 
```

<!-- As you can see, both code run throws the error cannot cast to GinRummyPlayer, which I believe we are casting the Player to the GinRummyPlayer interface in the vermouth jar, which is not possible because we make it implement the GinrummyPlayer interface in the original project. -->

# Run jar files: (The jar file is in the path `./target/botpackage-0.1.0.jar`)

1. Run the botpackage jar on its own:
```
java -cp ./assets/slf4j-simple-2.0.0-alpha1.jar:./target/botpackage-0.1.0.jar ginrummy.GinRummyGame
```

2. Run with the vermouth jar project:
```
java -cp ./target/botpackage-0.1.0.jar:./assets/slf4j-simple-2.0.0-alpha1.jar:./vermouth/vermouth.jar eaai.ginrummy.Main --oneall --games 100 --agents 'jar:file:./target/botpackage-0.1.0.jar!/AdvancedPlayer' 'jar:file:./target/botpackage-0.1.0.jar!/AdvancedPlayer'
```
