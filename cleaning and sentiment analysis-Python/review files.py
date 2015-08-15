import json

# Importing the files

b_file=open(r'businessProc2.json','r')
rs_file=open(r'reviewSentiments.json','r')

business_id=[]
reviews=[]


for line in b_file:
    business_id.append((json.loads(line).get('business_id')))
b_file.close()
print('got ids')

for ln in rs_file:
    reviews.append(json.loads(ln))
rs_file.close()
print('got reviews')

i=0
for id in business_id:
    k=[]
    for rs in reviews:
        if(rs.get('business_id')==id):
            k.append(rs)
    
    fp=open(r'data/'+id+r'.json','w')
    fp.write('[')
    count=0
    for l in k:
        json.dump(l,fp)
        fp.write('\n')
        count=count+1
        if(count!=len(k)):
            fp.write(',')

    fp.write(']')
    fp.close()
    i=i+1
    print(i)

print('complete')
        
        
    
