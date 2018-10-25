#!/usr/bin/python

from collections import Counter

import sys

#inizio a salvarmi il numero di tennisti da salvare
indice = int(sys.argv[2]);
#lettura di tutte le righe
with open(sys.argv[1], 'r') as input_file:
	file_rows = input_file.readlines();
#mi creo la lista dei nomi di file di campo dei file di input
nomi = file_rows.pop(0).rstrip().split(',');

#poi inserisco gli elementi:
#come chiave utilizzo il nome del campo,
#come valore inserisco a che posizione si trova
field_name_mapping = dict([(nomi[i], i) for i in range(len(nomi))]);

#stampa di prova
#print(field_name_mapping.items());
#fine stampa prova

lista_vittorie = []

for row in file_rows:
	fields = row.rstrip().split(',')
	if fields[field_name_mapping['round']] == 'F':
		lista_vittorie.append((fields[field_name_mapping['winner_id']],fields[field_name_mapping['winner_name']],fields[field_name_mapping['winner_hand']]))
		
#stampa di prova
#for n in lista_vittorie:
#	print(n)
#fine stampa di prova

#prova parte finale
contatore = Counter(lista_vittorie)
#creo la lista con le robe in ordine
listaFinale = contatore.most_common()
#e poi stampo
for i in range(indice):
	print(listaFinale[i])

