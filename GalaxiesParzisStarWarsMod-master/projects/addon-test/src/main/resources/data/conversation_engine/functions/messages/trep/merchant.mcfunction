# run as the player

# message id: 10

# reset the sucsess scoreboard
scoreboard players set @s CE_suc 0
scoreboard players set @s CE_resend 0

# check if the player came from a valid previous node (to prevent manual use of /trigger)
execute if score @s CE_current_node matches 8 run scoreboard players set @s CE_suc 1

# special case in case the previous node is itself in that case CE_resend of @s is set to 1 (use this to prevent commands that for example give items are executed twice)
execute store success score @s CE_resend if score @s CE_current_node matches 10 run scoreboard players set @s CE_suc 1

    # give the choices
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"The Merchant Station is a machine that allows a player","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"to convert an item into another. For example:","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":" ","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"    - Put a Copper Block into a galaxy forge and you will get a Bronze Credit","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"    ","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"    - Put a Iron Block into a galaxy forge and you will get a Silver Credit","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"    ","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"    - Put a Gold Block into a galaxy forge and you will get a Gold Credit","color":"white"}]
    execute if score @s CE_suc matches 1 run function conversation_engine:messages/trep/end


    # update the last run node
    execute if score @s CE_suc matches 1 run scoreboard players operation @s CE_current_node = @s CE_trigger
