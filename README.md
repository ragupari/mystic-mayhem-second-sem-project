# Mystic Mayhem

Mystic Mayhem is an interactive command-line game where players can build their armies, buy equipment, and declare wars against other players. The game maintains records for each player and allows for strategic battles to be fought.

## Features
- **Player Management**: Create new players or log in to existing ones.
- **Army Management**: View, buy, and sell armies and equipment.
- **Homeground Setting**: Choose a homeground for your armies.
- **Player Interaction**: View other players and declare wars.
- **Battle System**: Engage in battles with other players upon mutual agreement.

## Getting Started
### Running the Game
To start the game, navigate to the directory containing the `executable_file.jar` and run the following command:
Game Structure
Player Creation
At the beginning of the game, a few default players are automatically created. Each player has a unique username:

GeraltofRivia with username 'whitewolf'
Parishith with username 'pari'
Kajaluxan with username 'kajali'
Sukithan with username 'Suki'
Vithusanaa with username 'Vithu'
For each player, the game will:

Create a new file 'username'.txt inside the Players folder.
Add a record in the players.csv file for both existing and new players.
Login and Player Management
You can either create a new player or log in to an existing player using the appropriate username. Note: Usernames are case-sensitive.

Welcome Page
On the welcome page, you have access to the following options:

Show my army - View the details of your army.
Buy army - Purchase new army units.
Buy equipment - Buy equipment for your army.
Sell army - Sell units from your army.
Set my homeground - Choose and set your homeground.
Show other players - View stats of other players and declare war.
Go to War - Accept war invitations and see battle results.
Declaring War
To test the functionality of the game:

Go to the 6. Show other players section.
View the stats of other players (these will be randomly shown).
Declare war on a player from this section.
Log in as the other player.
Under 7. Go to War, accept the war invitation to see the battle results.
Important Notes
Before going to battle, make sure to buy at least one character from each army category.
If you choose options outside of the provided ones, it might cause errors.

### Prerequisites
To run the game, make sure you have the Java Runtime Environment (JRE) installed. You'll need to use the `--enable-preview` flag to run the executable JAR file.

```bash
java --enable-preview -jar executable_file.jar
