
faturamento_estadual =  {}
faturamento_estadual['SP'] = 67836.43
faturamento_estadual['RJ'] = 36678.66
faturamento_estadual['MG'] = 29229.88
faturamento_estadual['ES'] = 27165.48
faturamento_estadual['Outros'] = 19849.53

faturamento_total = sum(faturamento_estadual.values())
print(f"Faturamento total: {faturamento_total:.2f}")
      
for chave, valor in faturamento_estadual.items():
    percentual = (valor/ faturamento_total)*100
    print(f"{chave} - {percentual:.2f}%")

