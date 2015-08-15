import json

#Importing the files
checkin_file=r'checkin.json'
business_file=r'business.json'
review_file=r'review.json'
user_file=r'user.json'
tip_file=r'tip.json'

#Initailize the file pointers for each file
f_business=open(business_file,'r');
f_checkin=open(checkin_file,'r');
f_tip=open(tip_file,'r');
f_user=open(user_file,'r');
f_review=open(review_file,'r');


#store the business and user ids
business_id=[]
user_id=[]


#Extract the data corresponding to Phoenix
print('Cleaning Business data...........')
fp=open('businessProc.json','w')
fp.write(r'[')
for line in f_business:
    k=json.loads(line)
    if(k.get('city')=='Phoenix' or k.get('city')=='phoenix'):
        if 'Restaurants' in k.get('categories'):
            business_id.append(k.get('business_id'))
            json.dump(k,fp)
            fp.write(",")
            fp.write("\n")

fp.write(r']');
f_business.close()
fp.close()
print('Business data Cleaned')


#Extract the reviews to the corresponding business ID's
print('Cleaning review data...........')
fp=open('reviewProc.json','w')

for line in f_review:
    k=json.loads(line)
    for id in business_id:
        if(k.get('business_id')==id):
            json.dump(k,fp)
            fp.write("\n")

fp.close()
f_review.close()
print('review data Cleaned')


#Extract the tip info for the coreesponding business ID
print('Cleaning tip data...........')
fp=open('tipProc.json','w')
for line in f_tip:
    k=json.loads(line)
    for id in business_id:
        if(k.get('business_id')==id):
            user_id.append(k.get('user_id'))
            json.dump(k,fp)
            fp.write("\n")

fp.close()
f_tip.close()
print('tip data Cleaned')


#Extract the checkin info for the corresponding  business ID
fp=open('checkinProc.json','w')
fp.write(r'[')
for line in f_checkin:
    k=json.loads(line)
    for id in business_id:
        if(k.get('business_id')==id):
            json.dump(k,fp)
            fp.write(",")
            fp.write("\n")
fp.write(r']')
fp.close()
f_checkin.close()
print('checkin data Cleaned')


#Extract the users corresponding to the reviews
print('Cleaning User data.....')
print('parsing user file')
fp=open('userProc.json','w')
for ln in f_user:
    k=json.loads(ln)
    c=0
    for id in user_id:
        if(k.get('user_id')==id and c==0):
            c=1
            json.dump(k,fp)
            fp.write("\n")

fp.close()
f_user.close()
print('User data Extracted')
