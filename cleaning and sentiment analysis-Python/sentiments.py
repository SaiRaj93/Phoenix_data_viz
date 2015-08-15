
import json
from textblob import TextBlob
from textblob.sentiments import NaiveBayesAnalyzer


fp_review=open(r'reviewProc.json','r')
fp_out=open(r'reviewSeniments.json','w')

i=0
for line in fp_review:
    l=json.loads(line)
    j=TextBlob(l.get('text'),analyzer=NaiveBayesAnalyzer()).sentiment
    l.update({'class':j.classification,'pos':j.p_pos, 'neg':j.p_neg})
    json.dump(l,fp_out)
    fp_out.write('\n')
    i=i+1
    print(i)


print("Sentiments generated")
    
