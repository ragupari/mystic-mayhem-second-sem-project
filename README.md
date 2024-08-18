<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mystic Mayhem - README</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        h1, h2 {
            color: #333;
        }
        code {
            background-color: #f4f4f4;
            padding: 2px 4px;
            border-radius: 4px;
            font-family: Consolas, "Courier New", monospace;
            color: #d14;
        }
        pre {
            background-color: #333;
            color: #eee;
            padding: 15px;
            border-radius: 5px;
            overflow-x: auto;
        }
        ul {
            list-style-type: disc;
            margin-left: 20px;
        }
    </style>
</head>
<body>
    <h1>Mystic Mayhem</h1>
    <p>Mystic Mayhem is a strategic multiplayer game where players create and manage armies, declare wars, and engage in epic battles. The game provides a rich experience with various features and options for players to explore.</p>

    <h2>Running the Game</h2>
    <p>To run the game, use the following command:</p>
    <pre><code>java -jar --enable-preview executable_file.jar</code></pre>

    <h2>Game Structure</h2>

    <h3>Player Creation</h3>
    <p>At the beginning of the game, a few default players are automatically created. Each player has a unique username:</p>
    <ul>
        <li><strong>GeraltofRivia</strong> with username <code>'whitewolf'</code></li>
        <li><strong>Parishith</strong> with username <code>'pari'</code></li>
        <li><strong>Kajaluxan</strong> with username <code>'kajali'</code></li>
        <li><strong>Sukithan</strong> with username <code>'Suki'</code></li>
        <li><strong>Vithusanaa</strong> with username <code>'Vithu'</code></li>
    </ul>
    <p>For each player, the game will:</p>
    <ul>
        <li>Create a new file <code>'username'.txt</code> inside the <code>Players</code> folder.</li>
        <li>Add a record in the <code>players.csv</code> file for both existing and new players.</li>
    </ul>

    <h3>Login and Player Management</h3>
    <p>You can either create a new player or log in to an existing player using the appropriate username. <strong>Note:</strong> Usernames are case-sensitive.</p>

    <h3>Welcome Page</h3>
    <p>On the welcome page, you have access to the following options:</p>
    <ul>
        <li><strong>Show my army</strong> - View the details of your army.</li>
        <li><strong>Buy army</strong> - Purchase new army units.</li>
        <li><strong>Buy equipment</strong> - Buy equipment for your army.</li>
        <li><strong>Sell army</strong> - Sell units from your army.</li>
        <li><strong>Set my homeground</strong> - Choose and set your homeground.</li>
        <li><strong>Show other players</strong> - View stats of other players and declare war.</li>
        <li><strong>Go to War</strong> - Accept war invitations and see battle results.</li>
    </ul>

    <h3>Declaring War</h3>
    <p>To test the functionality of the game:</p>
    <ul>
        <li>Go to the <strong>Show other players</strong> section.</li>
        <li>View the stats of other players (these will be randomly shown).</li>
        <li>Declare war on a player from this section.</li>
        <li>Log in as the other player.</li>
        <li>Under <strong>Go to War</strong>, accept the war invitation to see the battle results.</li>
    </ul>

    <h3>Important Notes</h3>
    <ul>
        <li>Before going to battle, make sure to buy at least one character from each army category.</li>
        <li>If you choose options outside of the provided ones, it might cause errors.</li>
    </ul>
</body>
</html>
