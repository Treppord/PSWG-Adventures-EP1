# run as the player

# message id: 7

# reset the sucsess scoreboard
scoreboard players set @s CE_suc 0
scoreboard players set @s CE_resend 0

# check if the player came from a valid previous node (to prevent manual use of /trigger)
execute if score @s CE_current_node matches 2 run scoreboard players set @s CE_suc 1

# special case in case the previous node is itself in that case CE_resend of @s is set to 1 (use this to prevent commands that for example give items are executed twice)
execute store success score @s CE_resend if score @s CE_current_node matches 7 run scoreboard players set @s CE_suc 1

    # give the choices
    execute if score @s CE_suc matches 1 run tellraw @s [{"text":"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n","color":"white"}]
    scoreboard players set @s CE_buy_count 0
    execute if score @s CE_suc matches 1 if score @s CE_resend matches 0 store result score @s CE_buy_count run clear @s pswg-addon-test:gold_credit 0
    execute if score @s CE_buy_count matches 2.. run clear @s pswg-addon-test:gold_credit 2
    execute if score @s CE_buy_count matches 2.. run give @s pswg-addon-test:beskar_scraps 3
    execute if score @s CE_suc matches 1 run function conversation_engine:messages/trep/end


    # update the last run node
    execute if score @s CE_suc matches 1 run scoreboard players operation @s CE_current_node = @s CE_trigger
