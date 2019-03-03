import { Injectable } from '@angular/core';
import { Log } from '../model/Log';
import { BehaviorSubject } from '../../../node_modules/rxjs';


@Injectable({
  providedIn: 'root'
})
export class LogService {

  constructor() { }
  logs: Log[];
  private logSource = new BehaviorSubject<Log>({
    id: null, title: null, date: null
  });

  selectedLog = this.logSource.asObservable();

  getLogs(): Log[] {
    this.logs = [
      // {
      //   id:"1",
      //   title: 'Generated Component',
      //   date: new Date('02-Mar-2019')
      // },
      // {
      //   id:"2",
      //   title: 'Added Log',
      //   date: new Date('01-Mar-2019')
      // },
      // {
      //   id:"1",
      //   title: 'Text Log',
      //   date: new Date('03-Mar-2019')
      // }
    ];

    if( localStorage.getItem('logs') === null ) {
      this.logs = [];
    } else {
      this.logs = JSON.parse(localStorage.getItem('logs'));
    }
    return this.logs;
  }

  setFormLog(log:Log) {    
    this.logSource.next(log);
  }

  addLog(log: Log) {
    this.logs.unshift(log);
    localStorage.setItem('logs', JSON.stringify(this.logs));    
  }

  updatedLog(updatedLog: Log) {    
    this.logs.forEach( (cur, index) => {
      if(cur.id === updatedLog.id) {
        this.logs.splice(index, 1);
        this.logs.unshift(updatedLog);
      }
    });

    localStorage.setItem('logs', JSON.stringify(this.logs));
  }

  deleteLog(log: Log) {
    this.logs.forEach( (cur, index) => {
      if(cur.id === log.id) {
        this.logs.splice(index, 1);
      }
    })

    localStorage.setItem('logs', JSON.stringify(this.logs));
  }
}
