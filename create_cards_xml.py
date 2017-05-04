import os
card_names = os.listdir("core/assets/raw_textures/cards")
ammended_card_names = []
for card in card_names:
    y = 0
    for x in card:
        if x == '.':
            print card[:-4]
            ammended_card_names.append(card[: -4])
            y += 1

print ammended_card_names

beispiel = '<m%i> <attribs health=\"%i" attack=\"%i\" cost=\"%i\" mp=\"%i\" textureName=\"%s\" name=\"%s\"/></m%i>'
