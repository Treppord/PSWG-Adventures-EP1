# run as the player

# message id: 11

# reset the sucsess scoreboard
scoreboard players set @s CE_suc 0
scoreboard players set @s CE_resend 0

# check if the player came from a valid previous node (to prevent manual use of /trigger)
execute if score @s CE_current_node matches 8 run scoreboard players set @s CE_suc 1

# special case in case the previous node is itself in that case CE_resend of @s is set to 1 (use this to prevent commands that for example give items are executed twice)
execute store success score @s CE_resend if score @s CE_current_node matches 11 run scoreboard players set @s CE_suc 1

    # give the choices
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"The Blaster Table is a machine that allows a player","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"to create blasters. For example:","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":" ","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"    - 1x Durasteel Rod + 1x Trooper Holodrive + 1x Desh Coil = Blaster DC15","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"    ","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"    - 1x Durasteel Rod + 1x Holodrive + 1x Desh Coil = Blaster A280","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"    ","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"    - 1x Durasteel Rod + 1x Tatooine Holodrive + 1x Desh Coil = Blaster Cycler","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"    ","color":"white"}]
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"    - 1x Durasteel Rod + 1x Imperial Holodrive + 1x Desh Coil = Blaster E11","color":"white"}]
    execute if score @s CE_suc matches 1 run function conversation_engine:messages/trep/end


    # update the last run node
    execute if score @s CE_suc matches 1 run scoreboard players operation @s CE_current_node = @s CE_trigger
